#include<bits/stdc++.h>
using namespace std;
class Dice{
    private :
    int count_Dice;
    public : 
    void setCountDice(int count_Dice)
    {
        this -> count_Dice = count_Dice;
    }
    int roll()
    {
        srand(time(0));
        return rand()%(count_Dice*6)+1;
    }
};
