class TaskManager {

    private record TaskData(int userId, int priority) { }

    private final Map<Integer, TaskData> tasksUsers;
    private final NavigableMap<Integer, Queue<Integer>> priorityTasks;

    public TaskManager(List<List<Integer>> tasks) {
        tasksUsers = new HashMap<>();
        priorityTasks = new TreeMap<>();
        for (var triple : tasks) {
            tasksUsers.put(triple.get(1), new TaskData(triple.get(0), triple.get(2)));
            addPriorityTask(triple.get(2), triple.get(1));
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        tasksUsers.put(taskId, new TaskData(userId, priority));
        addPriorityTask(priority, taskId);
    }
    
    public void edit(int taskId, int newPriority) {
        TaskData task = tasksUsers.get(taskId);
        removePriorityTask(task.priority, taskId);
        add(task.userId, taskId, newPriority);
    }
    
    public void rmv(int taskId) {
        TaskData task = tasksUsers.get(taskId);
        removePriorityTask(task.priority, taskId);
        tasksUsers.remove(taskId);
    }
    
    public int execTop() {
        Map.Entry<Integer, Queue<Integer>> last = priorityTasks.lastEntry();
        if (last == null) {
            return -1;
        }

        Queue<Integer> tasks = last.getValue();
        int taskId = tasks.peek();
        TaskData taskData = tasksUsers.get(taskId);

        removePriorityTask(last.getKey(), taskId);
        tasksUsers.remove(taskId);

        return taskData.userId;
    }

    private void addPriorityTask(int priority, int taskId) {
        Queue queue = priorityTasks.getOrDefault(priority, new PriorityQueue(Collections.reverseOrder()));
        queue.offer(taskId);
        priorityTasks.put(priority, queue);
    }

    private void removePriorityTask(int priority, int taskId) {
        Queue queue = priorityTasks.get(priority);
        if (queue.size() == 1) {
            priorityTasks.remove(priority);
        }
        else {
            queue.remove(taskId);
            priorityTasks.put(priority, queue);
        }
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */