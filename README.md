# Number of Tables at a Wedding Using Union-Find

This goal of this program is to find out how many tables are necessary for guests at a wedding given that guests must know at least one other person at the table. To do this, the program takes in an input file that indicates which guests know each other. The program uses a disjoint-set data structure to calculate the answer to how many tables are necessary.

This Java program takes in a input file of the form:
```
10 5
1 2
3 4
5 6
6 7
9 10
```

where the first number in the first row is the number of guests at the wedding, and the second number in the first row is the number of lines following the first line. The format is <INTEGER><SPACE><INTEGER><RETURN>. The lines following the first row indicate that the first number (guest) knows the second number (guest). For example, in the input file, given, 10 is the number of guests at the wedding. 5 is the number of lines following the first line. Next, guest 1 knows guest 2, guest 3 knows guest 4, and so on.

This repository also includes a PDF report that describes the algorithm design and complexity in greater detail. 

## Getting Started

To test the program, import the 'UnionFind_ChandlerKlein/' Eclipse project into your workspace. Make sure you have the correct eclipse version and are using a compatible Java version.

### Prerequisites

```
Eclipse version 4.14.0
```
```
Java SDK version 13
``` 

## Author

* **Chandler Klein** - [KleinC16](https://github.com/KleinC16)

## License

This project is licensed under the GPL-3.0 License - see the [LICENSE.md](LICENSE.md) file for details

## References

* [Techie Delight](https://www.techiedelight.com/disjoint-set-data-structure-union-find-algorithm/)

* [Disjoint-set data structure](https://en.wikipedia.org/wiki/Disjoint-set_data_structure)