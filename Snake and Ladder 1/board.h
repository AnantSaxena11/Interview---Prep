#include<bits/stdc++.h>
using namespace std;
class Board{
    private:
    int size;
    vector<int> board;
    public:
    Board(int size)
    {
        this -> size = size;
        board.resize(size);
        for(int i = 1;i<=size;i++)
        {
            board[i-1] = i;
        }
    }
};