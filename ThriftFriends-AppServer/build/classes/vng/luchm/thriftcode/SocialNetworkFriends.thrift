namespace java vng.luchm.thrift
enum ActionUser {
    PENDING = 1,
    ACCEPTED = 2,
    DECLINED = 3,
    DELETED = 4
}
struct FriendLists {
    1: string UserId,
    2: i32 Status,
    3: string ActionUser
}
struct User {
    1: string Id,
    2: string UserName,
    3: list<FriendLists> Friends
}
service SocialNetworkFriendsService {
    bool requestAction(1:string id_user_one, 2:string id_user_two, 3:ActionUser action),
    list<User> getAllUsers(),
    User getUserById(1:string id),
    bool registerUser(1:string un),
    bool loginUser(1:string un)
}



