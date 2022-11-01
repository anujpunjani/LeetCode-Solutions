for(int i = 0; i < grid.length; i++) {
for(int j = 0; j < grid[0].length; j++) {
char c = grid[i][j] == 1? '/' : '\\';
System.out.print(c + " ");
}
System.out.println();
}