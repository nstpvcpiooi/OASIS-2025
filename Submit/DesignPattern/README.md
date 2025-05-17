# Family Tree Implementation using Composite Pattern

## Overview
This project implements a family tree system using the Composite Design Pattern. The Composite Pattern is particularly suitable for this use case as it allows us to treat individual people and groups of people (families) uniformly in a tree structure.

## Design Pattern Explanation
The Composite Pattern is used here because:
- Each person can be either a leaf node (no children) or a composite node (has children)
- We can perform operations on both individual people and groups of people in the same way
- The tree structure naturally represents family relationships

## Implementation Details

### Person Class
The `Person` class represents a node in our family tree with the following features:
- Basic information: name, gender, birth date
- Relationship information: spouse and children
- Methods for managing relationships:
  - `marry(Person spouse)`: Establishes marriage relationship
  - `addChild(Person child)`: Adds a child to the person
  - `getChildren()`: Returns list of children
  - `isMarried()`: Checks marriage status

### Key Functionality
The implementation includes three main operations:

1. Finding Unmarried People
```java
public List<Person> getUnmarriedPeople();
```
- Recursively traverses the family tree
- Returns a list of all unmarried individuals

2. Finding Couples with Two Children
```java
public List<Person[]> getCouplesWithTwoChildren();
```
- Identifies married couples who have exactly two children
- Returns pairs of spouses meeting this criterion

3. Finding Latest Generation
```java
public List<Person> getLatestGeneration();
```
- Identifies the youngest generation in the family tree
- Returns all individuals who have no children

## Example Usage
The `FamilyTreeDemo` class demonstrates the implementation with a sample family structure:
- James and Hana are married
- They have two children: Ryan and Kai
- Kai marries Jennifer
- Kai and Jennifer have four children

## How to Run
To run the demo:
```bash
java FamilyTree.FamilyTreeDemo
```

## Output
The program will display:
1. List of all unmarried people in the family
2. Couples who have exactly two children
3. Members of the latest generation

## Extensibility
The implementation is designed to be easily extensible:
- New family relationships can be added
- Additional operations can be implemented by adding new methods to the Person class
- The tree structure can be traversed in different ways for different purposes 