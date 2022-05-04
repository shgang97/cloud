import random
import time
from threading import Thread

import requests


class RelationThread(Thread):

    def run(self):
        while True:
            base_url1 = "http://127.0.0.1:8301/borrow/book/1"
            a = random.random()
            time.sleep(a)
            requests.get(base_url1)


class ResourceThread(Thread):

    def run(self):
        i = 0
        while True:
            i = i + 1
            time.sleep(0.5)
            base_url2 = "http://127.0.0.1:8301/borrow/1/1"
            response = requests.get(base_url2)
            print("第%s次请求结果：%s" % (i, response.text))


if __name__ == '__main__':
    relationT = RelationThread()
    relationT.start()

    resourceT = ResourceThread()
    resourceT.start()


