package com.bgrummitt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AStar {

    private Node[][] nodeMaze;
    private int[][] baseMaze;
    private List<Node> openNodes;
    private List<Node> closedNodes;

    public AStar(int[][] basicMaze){
        this.nodeMaze = new Node[basicMaze.length][basicMaze[0].length];
        this.baseMaze = basicMaze;
    }

    public int[][] solveMaze(int[] startPoint, int[] endPoint){
        int[][] path = new int[nodeMaze.length][nodeMaze[0].length];
        openNodes = new ArrayList<>();
        closedNodes = new ArrayList<>();

        Node endNode = new Node(endPoint, endPoint);

        openNodes.add(new Node(startPoint, endPoint, Node.OPEN));
        nodeMaze[startPoint[1]][startPoint[0]] = openNodes.get(0);
        nodeMaze[endPoint[1]][endPoint[0]] = endNode;

        while(endNode.getType() != Node.CLOSED && openNodes.size() != 0){
//            printOpenInOrder();
//            System.out.println(openNodes.size());
            closedNodes.add(openNodes.get(0));
            openNodes.remove(0);
            testSurroundingNodes(closedNodes.get(closedNodes.size() - 1), endPoint);
        }

        if(endNode.getParent() != null){
            showRoute(endNode, startPoint, baseMaze);
        }else{
            System.out.println("BROKEN");
        }

        return baseMaze;
    }

    public void showRoute(Node node, int[] base, int[][] map){
        if(node.getCoordinates() == base){
            map[base[1]][base[0]] = 5;
        }else{
            int[] coords = node.getCoordinates();
            System.out.println(" X = " + coords[0] + " --- Y = " + coords[1]);
            showRoute(node.getParent(), base, map);
            map[coords[1]][coords[0]] = 5;
        }
    }

    public void populateMaze(int[][] basicMaze, int[] endPoint){
        for(int i = 0; i < basicMaze.length; i++){
            for(int j = 0; j < basicMaze[0].length; j++){

                Node nodeToAdd = new Node(new int[]{i,j}, endPoint);

                if(basicMaze[i][j] == 1){
                    nodeToAdd.updateType(Node.BLOCKED);
                }

                nodeMaze[i][j] = nodeToAdd;

            }
        }
    }

    private int findLowestDistance(List<Node> nodes){
        Node largestNode = nodes.get(0);
        int largestNodePosition = 0;

        for(int i = 1; i < nodes.size(); i++){
            if(nodes.get(i).isGreaterThan(largestNode)){
                largestNode = nodes.get(i);
                largestNodePosition = i;
            }
        }

        return largestNodePosition;
    }

//    private void testSurroundingNodes(Node currentNode, int[] endPoint){
//        int[] currentPos = currentNode.getPosition();
//        int xMin = currentPos[0] - 1;
//        int yMin = currentPos[1] - 1;
//
//        for(int i = yMin; i < (yMin + 3); i++){
//            for(int j = xMin; j < (xMin + 3); j++){
//
//                if(i != currentPos[0] && j != currentPos[1] && withinBounds(j, i)){
//
////                    System.out.printf("X = %d --- Y = %d\n", j, i);
//
//                    Node surrounding = nodeMaze[i][j];
//
//                    if(surrounding == null){
//                        initialiseNode(j, i, endPoint, currentNode);
//                        surrounding = nodeMaze[i][j];
//                    }
//
//                    if(surrounding.getType() == Node.OPEN){
//                        if(surrounding.getG() > currentNode.getG() + 1){
//                            surrounding.setParent(currentNode);
//                            surrounding.setG(currentNode.getG() + 1);
//                            surrounding.recalculateF();
//                            openNodes.sort(new SortNodesByG());
//                        }
//                    }else if(surrounding.getType() == -1){
//                        openNodes.add(surrounding);
//                        surrounding.setParent(currentNode);
//                        surrounding.setG(currentNode.getG() + 1);
//                        surrounding.updateType(Node.OPEN);
//                        surrounding.recalculateF();
//                    }
//                }
//            }
//        }
//    }

    private void testSurroundingNodes(Node currentNode, int[] endPoint){
        Node[] children = getChildren(currentNode, endPoint);

        for(Node child : children){

            child.setParent(currentNode);
            child.setG(currentNode.getG() + 1);
            child.recalculateF();

            if(child.getType() != Node.OPEN){
                openNodes.add(child);
            }

            openNodes.sort(new SortNodesByG());

        }
    }


    public Node[] getChildren(Node mainNode, int[] endPoint){
        List<Node> children = new ArrayList<>();
        int[] mainCoords = mainNode.getCoordinates();
        int[][] surroundings = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

        int[] newCoords = new int[2];

        for(int[] position : surroundings){
            newCoords[0] = mainCoords[0] + position[0];
            newCoords[1] = mainCoords[1] + position[1];

            if(newCoords[0] >= 0 && newCoords[1] >= 0 && newCoords[0] < baseMaze[0].length && newCoords[1] < baseMaze.length){
                if(nodeMaze[newCoords[1]][newCoords[0]] == null){
                    initialiseNode(newCoords[0], newCoords[1], endPoint, mainNode);
                }
                children.add(nodeMaze[newCoords[1]][newCoords[0]]);
            }

        }

        return Arrays.copyOf(children.toArray(), children.size(), Node[].class);
    }

    public void initialiseNode(int x, int y, int[] endPoint, Node parent){
        Node nodeToAdd = new Node(new int[]{x,y}, endPoint);
        if(baseMaze[y][x] == 1){
            nodeToAdd.updateType(Node.BLOCKED);
        }
        nodeMaze[y][x] = nodeToAdd;
        nodeMaze[y][x].setParent(parent);
    }

    public boolean withinBounds(int x, int y){
        return x >= 0 && y >= 0 && x < baseMaze[0].length && y < baseMaze.length;
    }

}
