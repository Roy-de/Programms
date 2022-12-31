void CoordinateDescent::lambda_train (
   double alpha ,                   // User-specified alpha, (0,1) (Greater than 0)
   int maxits ,                         // Maximum iterations, for safety only
   double eps ,                       // Convergence criterion, typically 1.e-5 or so
   int fast_test ,                      // Convergence via max beta change vs explained variance?
   double max_lambda ,        // Starting lambda, or negative for automatic computation
   int print_steps                    // Print lambda/explained table?
   )
{
   int ivar, ilambda, n_active ;
   double lambda, min_lambda, lambda_factor ;

Optimization Issues
   if (print_steps) {
      fopen_s ( &fp_results , "CDtest.LOG" , "at" ) ;
      fprintf ( fp_results , "\n\nDescending lambda training..." ) ;
      fclose ( fp_results ) ;
      }
   if (n_lambda <= 1)        // Nonsensical parameter from caller
      ireturn ;
/*
   Compute the minimum lambda for which all beta weights remain at zero
   This (slightly decreased) will be the lambda from which we start our descent.
*/
   if (max_lambda <= 0.0)
      max_lambda = 0.999 * get_lambda_thresh ( alpha ) ;
   min_lambda = 0.001 * max_lambda ;
   lambda_factor = exp ( log ( min_lambda / max_lambda ) / (n_lambda-1) ) ;
/*
   Repeatedly train with decreasing lambdas
*/
   if (print_steps) {
      fopen_s ( &fp_results , "CDtest.LOG" , "at" ) ;
      fprintf ( fp_results , "\nLambda  n_active  Explained" ) ;
      }
   lambda = max_lambda ;
   for (ilambda=0 ; ilambda<n_lambda ; ilambda++) {
      lambdas[ilambda] = lambda ;   // Save in case we want to use later
      core_train ( alpha , lambda , maxits , eps , fast_test , ilambda ) ;
      for (ivar=0 ; ivar<nvars ; ivar++)         // Save these in case we want them later
         lambda_beta[ilambda*nvars+ivar] = beta[ivar] ;
      if (print_steps) {
         n_active = 0 ;      // Count active predictors for user’s edification

Optimization Issues
         for (ivar=0 ; ivar<nvars ; ivar++) {
            if (fabs(beta[ivar]) > 0.0)
              ++n_active ;
            }
         fprintf ( fp_results , "\n%8.4lf %4d %12.4lf", lambda, n_active, explained ) ;
         }
      lambda *= lambda_factor ;
      }
   if (print_steps)
      fclose ( fp_results ) ;
}