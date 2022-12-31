import bisect
from operator import index


class SortedList:
    def __init__(self,*elements):
        self._list = sorted(elements)

    def index(self, item):
        i = bisect.bisect_left(self._list, item)
        if i < len(self._list) and self._list[i] == item:
            return index

    def delete(self, item):
        del self._list[self.index(item)]

    def add(self, item):
        bisect.insort(self._list, item)

    def __iter__(self):
        for item in self._list:
            yield item

    def __exists__(self, item):
        return self.index(item) is not None

sorted_list = SortedList(1,2,3,76,66,4,7,4)
4 in sorted_list
print(list(sorted_list))                                    