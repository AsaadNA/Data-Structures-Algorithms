#include <iostream>
#include <vector>

void find_min_denominations(int amount) {
	int denominations[10] = {1,2,5,10,20,50,100,500,1000,5000};
	std::vector<int> result;
	for(int i = 9; i >= 0; i--) {
		while(amount >= denominations[i]) {
			amount -= denominations[i];
			result.push_back(denominations[i]);
		}
	}

	//Printing the result
	for(int i = 0; i <= result.size()-1; i++)
		std::cout << result[i] << " ";
}


int main() 
{
	find_min_denominations(1988);
}