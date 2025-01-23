#include <bits/stdc++.h>
using namespace std;
class Dice
{
private:
    int count_Dice;

public:
    void setCountDice(int count_Dice)
    {
        this->count_Dice = count_Dice;
        srand(time(0));
    }
    int roll()
    {

        return rand() % (count_Dice * 6) + 1;
    }
};
