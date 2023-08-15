#include<iostream>
#include<vector>
#include<algorithm>
#include<stdio.h>

using namespace std;

int main() {
    vector<char> v1 = {'A', 'B', 'C', 'D'};

    cout<<next_permutation(v1.begin(), v1.end())<<endl;

    return 0;
}