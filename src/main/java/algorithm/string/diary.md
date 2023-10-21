# Map的遍历方式
## 1. for循环遍历
    Map<String,integer> map = new HasMap<>();
    for(String key : map.keySet()){
        System.out.println("key:"+key+",value:"+map.get(key));
    }
    //或者
    for(Map.Entry<String,Integer> entry : map.entrySet){
        System.out.println("key:"+entry.getKey()+",value:"+entry.getValue());
    }
## 2. 迭代器
    Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
    while (iterator.hasNext()) {
    Map.Entry<String, Integer> entry = iterator.next();
    System.out.println("key:" + entry.getKey() + ", value:" + entry.getValue());
    }
## 3. lambda表达式
    Map<String,integer> map = new HasMap<>();
    map.forEach((key, value) -> System.out.println("key:" + key + ", value:" + value));