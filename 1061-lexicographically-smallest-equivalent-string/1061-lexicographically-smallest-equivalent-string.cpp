class Solution {
public:
    
    class UnionFind {
        public:
		vector<int> parent;

		UnionFind(int n){
            
			for(int i=0;i<n;i++){
				parent.push_back(i);
			}
		}
        
		int getAbsoluteParent(int i){
			if(parent[i]==i){
				// absolute parent
				return i;
			}
			parent[i]=getAbsoluteParent(parent[i]);
			return parent[i];
		}

		void unify(int i, int j){
			int absoluteParentI = getAbsoluteParent(i);
			int absoluteParentJ = getAbsoluteParent(j);
			if(absoluteParentI<absoluteParentJ){

				parent[absoluteParentJ] = absoluteParentI ;
			}
			else{

				parent[absoluteParentI] = absoluteParentJ ;
			}
		}

	};
    
    string smallestEquivalentString(string s1, string s2, string baseStr) {
        UnionFind *uf = new UnionFind(26);

		string ans = "";

		for(int i=0 ; i<s1.size() ; i++){

			int charS1 = s1[i]-'a';
			int charS2 = s2[i]-'a';

			uf->unify(charS1, charS2);
		}

		for(int i=0 ; i<baseStr.size() ; i++){

			int smallestMappedChar  = uf->getAbsoluteParent(baseStr[i]-'a');

			ans += (char)(smallestMappedChar+'a');
		}

		return ans;
    }
};