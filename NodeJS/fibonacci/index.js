
const n = 42

const fib = n => {
	if (n == 0) {
		return 0
	}
	if (n == 1) {
		return 1
	}
	return fib(n - 1) + fib(n - 2)
}

console.time('array addition')

const result = fib(n)

console.timeEnd('array addition')

console.log(`fib(${n}) = ${result}`)