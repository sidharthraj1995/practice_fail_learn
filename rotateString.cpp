#include <iostream>
#include <cstring>

using namespace std;

/* 
Rotate each char of the string and return the rotated string
 */
string rotateString(string c) {
    string rotStr;
    for(int i=0; i <c.length(); i++) {
        if (c[i] == 'z' || c[i] == 'Z')
        {
            rotStr.push_back(c[i]-25);
        } else
        rotStr.push_back(c[i]+1);
    }    
    return rotStr;
}


int main() {

    string test;
    // cout << "Input a string to rotate: ";
    cin >> test;
    // cout << "This is the input: " << test << endl;


    // string f = rotateString(test);
    cout << rotateString(test);

    return 0;
}