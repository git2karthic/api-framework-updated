package bdd.cucumber.resources;

public enum APIResources {

    ListUsers("api/users?page=2"),
    SingleUser("api/users/"),
    SingleUserNotFound("api/users/23"),
    ListResources("api/unknown"),
    SingleResource("api/unknown/2"),
    SingleResourceNotFound("api/unknown/23"),
    CreateUser("api/users"),
    UpdateUser("api/users/2"),
    PatchUser("api/users/2"),
    DeleteUser("api/users/2"),
    RegisterSuccessful("api/register"),
    RegisterUnsuccessful("api/register"),
    DelayedResponse("api/users?delay=3");

    private String resource;

    APIResources(String res) {
        this.resource = res;
    }

    public String getResource() {
        return resource;
    }
}
