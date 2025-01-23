#include <bits/stdc++.h>
#include "dice.h"
#include "board.h"
#include "snake and ladder.h"
#include "players.h"
using namespace std;
class gamePlay
{
private:
    Dice dice;
    queue<Player> nextPlayer;
    vector<snakeandladder> snake;
    vector<snakeandladder> ladder;
    unordered_map<string, int> playersCurrentPosition;
    int boardSize;

public:
    gamePlay(Dice dice, queue<Player> nextPlayer, vector<snakeandladder> snake, vector<snakeandladder> ladder, unordered_map<string, int> playersCurrentPosition, int boardSize)
    {
        this->dice = dice;
        this->nextPlayer = nextPlayer;
        this->snake = snake;
        this->ladder = ladder;
        this->playersCurrentPosition = playersCurrentPosition;
        this->boardSize = boardSize;
    }
    void startGame()
    {
        cout<<"How many Dice do you want to play with"<<endl;
        int countDice;
        cin>>countDice;
        dice.setCountDice(countDice);
        while(nextPlayer.size()>1){
            Player player = nextPlayer.front();
            nextPlayer.pop();
            string name = player.getName();
            int currentPosition = playersCurrentPosition[name];
            int diceValue = dice.roll();
            int newPosition = currentPosition + diceValue;
            if(newPosition > boardSize)
            {
                nextPlayer.push(player);
            }
            else if(newPosition == boardSize)
            {
                cout<<name<<" wins the game"<<endl;
                nextPlayer.pop();
            }
            else
            {
                for(int i = 0;i<snake.size();i++)
                {
                    if(snake[i].getsnakeorladder().second == newPosition)
                    {
                        cout<<name<<" bitten by Snake pshhhh"<<endl;
                        newPosition = snake[i].getsnakeorladder().first;
                        break;
                    }
                }
                for(int i = 0;i<ladder.size();i++)
                {
                    if(ladder[i].getsnakeorladder().first == newPosition)
                    {
                        cout<<name<<" Climbed the ladder"<<endl;
                        newPosition = ladder[i].getsnakeorladder().second;
                        break;
                    }
                }
                cout<<name<<" moved from "<<currentPosition<<" to "<<newPosition<<endl;
                playersCurrentPosition[name] = newPosition;
                nextPlayer.push(player);
            }
        }
    }
};