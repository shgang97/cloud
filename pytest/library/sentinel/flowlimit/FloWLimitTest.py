import time
from threading import Thread

import requests


class ResourceThread(Thread):

    def run(self):
        i = 0
        while True:
            i = i + 1
            time.sleep(0.15)
            base_url2 = "http://127.0.0.1:8301/borrow/1/1"
            response = requests.get(base_url2)
            print("第%s次请求结果：%s" % (i, response.text))


if __name__ == '__main__':

    resourceT = ResourceThread()
    resourceT.start()


