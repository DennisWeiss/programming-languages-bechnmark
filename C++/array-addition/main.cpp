#include <stdio.h>
#include <chrono>
#include <cstdlib>
#include <stdio.h>


const int size = 1e7;

int main(int arg, char** argv) {
	
	float* arr = new float[size];
	
	for (int i = 0; i < size; i++) {
		arr[i] = (float) rand() / RAND_MAX;
	}
	
	auto start = std::chrono::steady_clock::now();
	
	for (int i = 0; i < size; i++) {
		arr[i] += 1.5f;
	}
	
	auto end = std::chrono::steady_clock::now();
	
	double time_ns = double(std::chrono::duration_cast <std::chrono::nanoseconds> (end - start).count());
	
	printf("Addition of %d elements took %fms...\n", size, time_ns / 1e6);
	
	getchar();

	return 0;
}