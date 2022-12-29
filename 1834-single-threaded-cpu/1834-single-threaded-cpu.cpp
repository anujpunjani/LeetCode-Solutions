class Solution {
public:

    class Compare {
        public:
            bool operator()(vector<int> &a, vector<int> &b) {
                if(a[1] == b[1])
                     return a[2] > b[2];
                return a[1] > b[1];
            }
    };
    
    vector<int> getOrder(vector<vector<int>>& tasks) {
        
        for(int i = 0; i < tasks.size(); i++)
            tasks[i].push_back(i);
        
        sort(tasks.begin(), tasks.end());
        
        priority_queue<vector<int>, vector<vector<int>>, Compare> available_tasks;
        vector<int> ans;
        
        int task_index = 0;
        long long current_time = 0;

        while(task_index < tasks.size() || available_tasks.size() > 0) {
            
            if(available_tasks.empty() && current_time < tasks[task_index][0])
                current_time = tasks[task_index][0];
            
            while(task_index < tasks.size() && tasks[task_index][0] <= current_time) {
                available_tasks.push({tasks[task_index][0], tasks[task_index][1], tasks[task_index][2]});
                task_index++;
            }
            
            vector<int> top = available_tasks.top(); available_tasks.pop();
            
            current_time += top[1];
            ans.push_back(top[2]);
        }
        
        return ans;
    }
};