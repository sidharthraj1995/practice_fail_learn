#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

// Rotate each char of the string and return the rotated string
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
/* 
SearchPartner() takes the input string vector 
along with the sample string, it find the partner
for Sample string
 */
int searchPartner(vector<string> rotInput, string sample) {
    string sampleRot;
    sampleRot = rotateString(sample);

    // Iterator used to store the position
    // of searched element
    std::vector<string>::iterator it;
    it = std::find(rotInput.begin(), rotInput.end(), sampleRot);
    auto pos = it - rotInput.begin();
    if (it != rotInput.end())
    {
        cout << "Element " << sample <<" partner found at position : " ;
        cout << pos << " (counting from zero) " << rotInput[pos] << endl;
    }
    else
    cout << "Element not found.\n\n";
    
    return 0;
}


int main() {
    std::vector<string> msg{"abc", "sfq", "xyz", "bcd", "pqy", "ret", "yza"};

    searchPartner(msg, msg[2]);
    searchPartner(msg, msg[0]);

    return 0;
}