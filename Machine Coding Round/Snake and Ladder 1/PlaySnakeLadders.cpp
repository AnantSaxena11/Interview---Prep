#include<bits/stdc++.h>
#include "gameplay.h"
using namespace std;
int main()
{
    cout<<"Welcome to Snake ladder Game"<<endl;
    cout<<"Enter the number of players"<<endl;
    int numberOfPlayers;
    cin>>numberOfPlayers;
    Dice dice;
    queue<Player> nextPlayer;
    unordered_map<string,int> playersCurrentPosition;
    for(int i = 0;i<numberOfPlayers;i++)
    {
        string name;
        cout<<"Enter the name of player"<<i+1<<endl;
        cin>>name;
        playersCurrentPosition[name] = 0;
        Player player(name,i);
        nextPlayer.push(player);
    }
    cout<<"Enter the board size"<<endl;
    int boardSize;
    cin>>boardSize;
    Board board(boardSize);
    vector<snakeandladder> snake;
    vector<snakeandladder> ladder;
    snakeandladder snake1(2,5);
    snake.push_back(snake1);
    snakeandladder snake2(10,50);
    snake.push_back(snake2);
    snakeandladder ladder1(20,30);
    ladder.push_back(ladder1);
    snakeandladder ladder2(40,60);
    ladder.push_back(ladder2);
    gamePlay game(dice,nextPlayer,snake,ladder,playersCurrentPosition,boardSize);
    game.startGame();
    return 0;
}