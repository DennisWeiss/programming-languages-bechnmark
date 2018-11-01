
const size = Math.pow(10, 7)

const arr = []

for (let i = 0; i < size; i++) {
	arr.push(Math.random())
}

console.time('array addition')

for (let i = 0; i < size; i++) {
	arr[i] += 1.5
}

console.timeEnd('array addition')
