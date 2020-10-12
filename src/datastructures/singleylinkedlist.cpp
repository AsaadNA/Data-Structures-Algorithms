#include <iostream>

class SLL {

    struct Node {
        int data;
        Node* next;
    };

    public:
        void Insert(const int data);
        void Remove(const int data);
        void Print();

    private:
        Node *head = nullptr;
        Node *curr = nullptr;
};

///

void SLL::Insert(const int data) {
    Node* newNode = new Node();
    newNode->data = data;
    if(head == nullptr) head = newNode;
    else {
        curr = head;
        while(curr->next != nullptr) curr = curr->next;
        curr->next = newNode;
    }
}

void SLL::Remove(const int data) {
    Node* temp = nullptr;
    curr = head;
    while(curr != nullptr && curr->data != data) {
        temp = curr;
        curr = curr->next;
    } if(curr->data == head->data) {
        head = head->next;
    } else if(curr->data == data) {
        temp->next = curr->next;
    }
}

void SLL::Print() {
    curr = head;
    while(curr != nullptr) {
        std::cout << curr->data << " ";
        curr = curr->next;
    }
}

///

int main() {
    SLL list;
    list.Insert(1);
    list.Insert(2);
    list.Insert(3);
    list.Insert(4);
    list.Insert(5);
    list.Remove(3);
    list.Remove(1);
    list.Remove(5);
    list.Print();
}