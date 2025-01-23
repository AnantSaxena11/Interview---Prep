#include<bits/stdc++.h>
using namespace std;
class snakeandladder
{
    private:
    pair<int,int> snakeorladder;
    public:
    snakeandladder(int startPoint,int endPoint)
    {
        snakeorladder.first = startPoint;
        snakeorladder.second = endPoint;
    }

    pair<int,int> getsnakeorladder()
    {
        return snakeorladder;
    }
};