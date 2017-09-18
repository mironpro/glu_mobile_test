package work;

interface LikeService
{
    void like(String playerId);
    long getLikes(String playerId);
}