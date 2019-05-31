//package com.petrl.mvvm.service.retrofit
//import githubrepo
//import retrofit2.http.GET
//import retrofit2.http.Path

const val GITHUB_API_BASE_URL = "https://api.github.com/"

interface GithubService{

    @GET("/users/{user}/repos")
    fun getRepos(@Path("user") user: String): Deferred<Response<List<GitHubRepo>>>

    companion object {
        fun getRetrofit():GithubService{
            return Retrofit.Builder()
                .baseUrl(GITHUB_API_BASE_URL)
                .addConvertedFactory(MoshiCoverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build().create(HithubService::class.java)
        }
    }

}