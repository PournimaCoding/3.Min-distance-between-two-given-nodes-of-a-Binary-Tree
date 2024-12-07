class MindistancebetweentwogivennodesofaBinaryTree {
    class Node {
        int data;  // Value stored in the node
        Node left; // Pointer to the left child
        Node right; // Pointer to the right child
    
        // Constructor to initialize a new node
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    public static Node lca(Node root, int a, int b){
        if(root == null || root.data == a||root.data==b){
            return root;
        }
        Node leftlca = lca(root.left,a,b);
        Node rightlca = lca(root.right,a,b);
        
        if(rightlca==null){
            return leftlca;
        }
        if(leftlca==null){
            return rightlca;
        }
        return root;
    }
    public static int getdist(Node root,int n){
        if(root==null){
            return -1;
        }
        if(root.data==n){
            return 0;
        }
        
        int leftdist = getdist(root.left,n);
        int rightdist = getdist(root.right,n);
        
        if(leftdist==-1 && rightdist==-1){
            return -1;
        }else if(leftdist==-1){
            return rightdist+1;
        }else{
            return leftdist+1;
        }
    }
    int findDist(Node root, int a, int b) {
        // Your code here
        Node lca = lca(root,a,b);
        int leftdist = getdist(lca,a);
        int rightdist = getdist(lca,b);
        
        int mindist = leftdist+rightdist;
        return mindist;
    }
    
    
}