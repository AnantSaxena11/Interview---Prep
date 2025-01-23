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
        cout << "How many Dice do you want to play with" << endl;
        int countDice;
        cin >> countDice;
        dice.setCountDice(countDice);

        while (nextPlayer.size() > 1)
        {
            Player player = nextPlayer.front();
            nextPlayer.pop();
            string name = player.getName();
            int currentPosition = playersCurrentPosition[name];
            int diceValue = dice.roll();
            cout << name << " rolled a dice and got " << diceValue << endl;

            if (player.getChaal() == false)
            {
                // Corrected the condition here to check if diceValue is 1 or 6
                if (diceValue == 1 || diceValue == 6)
                {
                    cout << name << " started the game" << endl;
                    player.setChaal(); // Player is now able to start
                }
                else
                {
                    cout << name << " needs 1 or 6 to start the game" << endl;
                    nextPlayer.push(player); // Push player back to the queue if they didn't roll 1 or 6
                }
            }
            if(player.getChaal() == true)
            {
                int newPosition = currentPosition + diceValue;
                if (newPosition > boardSize)
                {
                    cout << name << " rolled too high and remains at position " << currentPosition << endl;
                    nextPlayer.push(player); // Player stays in the queue without moving
                }
                else if (newPosition == boardSize)
                {
                    cout << name << " wins the game!" << endl;
                    // No need to add the winner back to the queue
                }
                else
                {
                    // Check for snakes
                    for (int i = 0; i < snake.size(); i++)
                    {
                        if (snake[i].getsnakeorladder().second == newPosition)
                        {
                            cout << name << " bitten by Snake pshhhh" << endl;
                            newPosition = snake[i].getsnakeorladder().first; // Move the player to the snake's tail
                            break;
                        }
                    }

                    // Check for ladders
                    for (int i = 0; i < ladder.size(); i++)
                    {
                        if (ladder[i].getsnakeorladder().first == newPosition)
                        {
                            cout << name << " Climbed the ladder" << endl;
                            newPosition = ladder[i].getsnakeorladder().second; // Move the player to the top of the ladder
                            break;
                        }
                    }

                    cout << name << " moved from " << currentPosition << " to " << newPosition << endl;
                    playersCurrentPosition[name] = newPosition; // Update player's position
                    nextPlayer.push(player);                    // Player continues in the game
                }
            }
        }
    }
};