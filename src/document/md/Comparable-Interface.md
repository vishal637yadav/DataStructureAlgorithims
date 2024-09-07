# Comparable Interface in Java

## Usage:
The **Comparable Interface** is **used** to **compare** an object of the same class with an instance of that class.
* It provides ordering of data for objects of the user-defined class.
* **java.lang.Comparable** interface need to be **implemented** to compare it's instance.
* **compareTo(ObjectOfSameClass o)** method need to be implemented.

### Problem
    Input : { {"abc",3},{"a",4},{"bc",5},{"a",2}}
    Output: { {"a",2},{"a",4},{"abc",3},{"bc",5}}

    Input : { {"efg",1},{"gfg",1},{"cba",1},{"zaa",1}}
    Output: { {"cba",1},{"efg",1},{"gfg",1},{"zaa",1}}
