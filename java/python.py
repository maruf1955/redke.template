class node:
    def __init__(self,data= None):
        self.data=data
        self.next= None
class sll:
    def __init__(self):
        self.head=None
        self.size=0
    def Head(self,data):
        h=node(data)
        self.head=h
        self.head.next=None  
        self.size+=1
    def traverse(self):
        a=self.head
        if self.isempty():
            print("list is empty")
        else:
            while a !=None:
                print(a.data,end=" ")
                a=a.next
    def isempty(self):
        if self.head== None:
            return True
        else:
            return False
    def insert_begain(self,data):
        ib=node(data)
        ib.next=self.head
        self.head=ib
        self.size+=1
    def insert_last(self,data):
        il=node(data)
        if self.isempty():
            print("list is empty")
        else:
            a=self.head
            while a.next is not None:
                a=a.next
            a.next=il
        self.size+=1
    def insert_sp_position(self,position,data):
        if position==0:
            self.insert_begain(data)
            self.size-=1
        else:
            sp=node(data)
            pre=self.head
            af=pre.next
            for i in range(1,position):
                pre=pre.next
                af=af.next
            pre.next=sp
            sp.next=af
        self.size+=1
    def deleteleft(self):
        if self.isempty():
            print("list is empty")
        else:
            a=self.head
            self.head=a.next
        self.size-=1
    def deleteright(self):
        if self.isempty():
            print("list is empty")
        else:
            pre=self.head
            af=pre.next
            while af.next is not None:
                af=af.next
                pre=pre.next
            pre.next=None
        self.size-=1
    def delete_sp_position(self,position):
        if self.isempty():
            print("list is empty")
        elif position==0:
            self.deleteleft()           
        else:
            pre=self.head
            af=pre.next
            for i in range(1,position):
                af=af.next
                pre=pre.next
            pre.next=af.next
        self.size-=1
    def tail(self):
        a=self.head
        while a.next is not None:
            a=a.next
        return a.data
    def addition(self):
        summ=0
        if self.isempty():
            print(0)
        else:
            a=self.head
            while a is not None:
                summ+=int(a.data)
                a=a.next
        print(summ)
    def index(self,data):
        if self.isempty():
            print("There is not any element in the list!..")
        else:
            a=self.head
            while a is not None:
                if a.data==data:
                    return str("The value ")+str(a.data)+str(" ")+str('is exist in this list..')
                a=a.next
            return f"The value {data} doesn't exist in this list"
    def remove_duplicate(self):
        be=self.head
        data=[be.data]
        af=be.next
        while af is not None:
            if af.data in data:
                af=af.next
            else:
                data.append(af.data)
                be=be.next
        print(data)
    def issorted(self):
        if self.isempty():
            print("There is not any element in this list!..")
        else:
            pre=self.head
            af=pre.next
            while af.next is not None:
                pre=pre.next
                af=af.next
                if int(pre.data)<int(af.data):
                    return True
                else:
                    return False
           
sl=sll()
sl.Head(0)
sl.insert_begain(-1)
sl.insert_begain(-2)
sl.insert_begain(-3)
sl.insert_last(3)
sl.insert_sp_position(4, 2)
sl.insert_sp_position(4, 1)
sl.deleteleft()
sl.deleteright()
sl.delete_sp_position(1)
sl.delete_sp_position(2)
sl.insert_last(10)
sl.insert_sp_position(1, -3)
sl.insert_sp_position(3, 9)
sl.insert_sp_position(4, 100)
sl.insert_sp_position(7, 8)
sl.insert_sp_position(0,8)
sl.delete_sp_position(8)
sl.delete_sp_position(0)
sl.insert_begain(10)
sl.traverse()
print()
print("Singly linked list size:",end=" ")
print(sl.size)
print("Singly lisnked list head is:",end=' ')
print(sl.head.data)
print("Singly linked list tail is: ",end=" ")
print(sl.tail())
print(f"Sum of all element is:",end=" ")
sl.addition()
print(sl.index(100))
print("Remove duplicate:",end=" ")
sl.remove_duplicate()
print("List issorted:",end="")
print(sl.issorted())