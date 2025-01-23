#include<bits/stdc++.h>
using namespace std;
class Player{
    private:
    string name;
    int id;
    bool chaal = false;
    public:
    Player(string name,int id)
    {
        this -> name = name;
        this -> id = id;
    }
    string getName()
    {
        return name;
    }
    void setChaal()
    {
        chaal = true;
    }
    bool getChaal()
    {
        return chaal;
    }
};