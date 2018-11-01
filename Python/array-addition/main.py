import timeit
import random


size = 10**7

lst = []

for i in range(size):
    lst.append(random.random())

start = timeit.default_timer()

for i in range(size):
    lst[i] += 1.5

time = timeit.default_timer() - start

print('Addition of {} elements took {}ms'.format(size, 1000 * time))
