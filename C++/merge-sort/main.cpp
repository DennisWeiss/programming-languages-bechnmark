#include <stdio.h>
#include <stdlib.h>
#include <chrono>

const int size = 1e6;

void copyArray(int* a, int* copy, int low, int length) {
  for (int i = 0; i < length; i++) {
    copy[i] = a[low + i];
  }
}

void merge(int* a, int low, int mid, int high) {
  int* temp = new int[high - low + 1];
  int i = low;
  int j = mid + 1;
  int k = 0;

  copyArray(a, temp, low, high - low + 1);

  while (i <= mid && j <= high) {
    if (a[i] < a[j]) {
      temp[k] = a[i];
      i++;
    } else {
      temp[k] = a[j];
      j++;
    }
    k++;
  }

  while (i <= mid) {
    temp[k] = a[i];
    i++;
    k++;
  }

  while (j <= high) {
    temp[k] = a[j];
    j++;
    k++;
  }

  int l = low;
  int m = 0;

  while (l <= high) {
    a[l] = temp[m];
    l++;
    m++;
  }

  delete[] temp;
}

void sort(int* a, int low, int high) {
  int mid = (low + high) / 2;
  if (high - low > 0) {
    sort(a, low, mid);
    sort(a, mid + 1, high);
  }
  merge(a, low, mid, high);
}

void sort(int* a, int length) { sort(a, 0, length - 1); }

int main(int argc, char** argv) {
  int* a = new int[size];

  for (int i = 0; i < size; i++) {
    a[i] = rand();
  }

  auto start = std::chrono::steady_clock::now();

  sort(a, size);

  auto end = std::chrono::steady_clock::now();

  double time_ns =
      double(std::chrono::duration_cast<std::chrono::nanoseconds>(end - start)
                 .count());

  printf("Sorting %d elements took %fms...\n", size, time_ns / 1e6);

  getchar();
  return 0;
}