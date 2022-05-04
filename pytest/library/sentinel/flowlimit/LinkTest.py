import time
from threading import Thread

import requests


class ResourceThread(Thread):

    def __init__(self, base_url):
        self.base_url = base_url
        super(ResourceThread, self).__init__()

    def run(self):
        i = 0
        while True:
            i = i + 1
            time.sleep(0.1)
            response = requests.get(self.base_url)
            print("第%s次请求结果：%s" % (i, response.text))


if __name__ == '__main__':
    # base_url = "http://127.0.0.1:8101/user/1"
    base_url = "http://127.0.0.1:8301/borrow/1/1"
    resourceT1 = ResourceThread(base_url)
    resourceT1.start()

    # base_url = "http://127.0.0.1:8102/user/1"
    # resourceT2 = ResourceThread(base_url)
    # resourceT2.start()


