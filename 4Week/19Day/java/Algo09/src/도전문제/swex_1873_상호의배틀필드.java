package 도전문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swex_1873_상호의배틀필드 {
    static char[][] graph;
    static int direction, h, w, x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            
            graph = new char[h][w];
            
            for (int r = 0; r < h; r++) {
                input = br.readLine();
                for (int c = 0; c < w; c++) {
                    graph[r][c] = input.charAt(c);
                    findStart(r, c);
                }
            }
            
            int N = Integer.parseInt(br.readLine());
            
            input = br.readLine();
            for (int i = 0; i < N; i++) {
                runCommand(input.charAt(i));
            }

            sb.append("#")
              .append(t)
              .append(" ");
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    sb.append(graph[i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }

    public static void findStart(int r, int c) {
        if (graph[r][c] == '^' || graph[r][c] == 'v' || graph[r][c] == '<' || graph[r][c] == '>') {
            x = r;
            y = c;
            switch (graph[r][c]) {
                case '^':
                    direction = 1;
                    break;
                case 'v':
                    direction = 2;
                    break;
                case '<':
                    direction = 3;
                    break;
                case '>':
                    direction = 4;
                    break;
            }
        }
    }

    public static void runCommand(char command) {
        switch (command) {
            case 'U':
                direction = 1;
                move();
                break;
            case 'D':
                direction = 2;
                move();
                break;
            case 'L':
                direction = 3;
                move();
                break;
            case 'R':
                direction = 4;
                move();
                break;
            case 'S':
                shoot();
                break;
        }
    }

    public static void move() {
        int newX = x;
        int newY = y;
        char status = 0;

        switch (direction) {
            case 1:
                newX--;
                status = '^';
                break;
            case 2:
                newX++;
                status = 'v';
                break;
            case 3:
                newY--;
                status = '<';
                break;
            case 4:
                newY++;
                status = '>';
                break;
        }

        if (0 <= newX && newX < h && 0 <= newY && newY < w && graph[newX][newY] == '.') {
            graph[x][y] = '.';
            x = newX;
            y = newY;
        }
        graph[x][y] = status;
    }

    public static void shoot() {
        switch (direction) {
            case 1:
                for (int i = x - 1; i >= 0; i--) {
                    if(wallX(i)) break;
                }
                break;
            case 2:
                for (int i = x + 1; i < h; i++) {
                	if(wallX(i)) break;
                }
                break;
            case 3:
                for (int i = y - 1; i >= 0; i--) {
                	if(wallY(i)) break;
                }
                break;
            case 4:
                for (int i = y + 1; i < w; i++) {
                	if(wallY(i)) break;
                }
                break;
        }
    }
    
    public static boolean wallX(int i) {
    	switch(graph[i][y]) {
    		case '*':
    			graph[i][y] = '.';
    		case '#':
    			return true;
    	}
    	return false;
    }
    
    public static boolean wallY(int i) {
    	switch(graph[x][i]) {
		case '*':
			graph[x][i] = '.';
		case '#':
			return true;
    	}
    	return false;
    }
}