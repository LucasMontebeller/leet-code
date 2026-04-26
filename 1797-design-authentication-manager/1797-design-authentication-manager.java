class AuthenticationManager {

    private final Map<String, Integer> tokens;
    private final int timeToLive;

    public AuthenticationManager(int timeToLive) {
        tokens = new LinkedHashMap<>();
        this.timeToLive = timeToLive;
    }
    
    public void generate(String tokenId, int currentTime) {
        tokens.put(tokenId, currentTime + timeToLive);
    }
    
    public void renew(String tokenId, int currentTime) {
        var expiration = tokens.getOrDefault(tokenId, 0);
        if (currentTime < expiration) {
            tokens.put(tokenId, currentTime + timeToLive);
        }
    }
    
    public int countUnexpiredTokens(int currentTime) {
        Iterator<Map.Entry<String, Integer>> it = tokens.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();

            if (entry.getValue() <= currentTime) {
                it.remove();
            }
        }

        return tokens.size();
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */