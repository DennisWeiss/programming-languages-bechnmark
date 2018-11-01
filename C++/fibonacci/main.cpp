#include <stdio.h>
#include <chrono>


int fib(int n) {
	if (n == 0) {
		return 0;
	}
	if (n == 1) {
		return 1;
	}
	return fib(n - 1) + fib(n - 2);
}

int main(int arg, char** argv) {

	int n = 42;
	
	auto start = std::chrono::steady_clock::now();
	
	int result = fib(n);
	
	auto end = std::chrono::steady_clock::now();
	
	double time_ns = double(std::chrono::duration_cast <std::chrono::nanoseconds> (end - start).count());
	
	printf("fib(%d) = %d\nComputation took %fms...\n", n, result, time_ns / 1e6);
	
	getchar();

	return 0;
}