import timeit


n = 42


def fib(n):
    if n == 0:
        return 0
    if n == 1:
        return 1
    return fib(n - 1) + fib(n - 2)


start = timeit.default_timer()

result = fib(n)

time = timeit.default_timer() - start

print('fib({}) = {}'.format(n, result))
print('Computation took {}ms'.format(1000 * time))
