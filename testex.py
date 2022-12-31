import asyncio
import inspect

class AsyncConstructor(type):
    async def __call__(cls, *args,**kwargs):
        inst = cls.__new__(cls,*args,**kwargs)
        if inspect.iscoroutinefunction(cls.__new__):
            inst = await inst

        if isinstance(inst,cls):
            if(
                (init :=inst.__init__(*args,**kwargs))
                and inspect.iscouroutinefunction(inst.__init__)
            ):
              await init
        return inst
        


class Example(metaclass = AsyncConstructor):
    async def __new__(cls,message):
        inst = super().__new__(cls)
        print("Created",message)
        return inst

    async def __init__(self, message):
        print(message)

async def main():
    instance = await Example("Hello World!")



asyncio.run(main())