CREATE TABLE IF NOT EXISTS FORBES_2000_2020(ranks INT, company VARCHAR, country VARCHAR,
sales VARCHAR, profit VARCHAR, assets VARCHAR, market_value VARCHAR,sector VARCHAR, Industry VARCHAR
);

COPY PUBLIC.FORBES_2000_2020 FROM '/home/roy/Downloads/DIS(1).csv' WITH csv header; 