package com.paulkg12.t61.http;

import android.support.annotation.NonNull;

import com.paulkg12.t61.http.model.IssueRequestModel;
import com.paulkg12.t61.mvp.model.Issue;
import com.paulkg12.t61.mvp.model.IssueEvent;
import com.paulkg12.t61.mvp.model.Label;
import com.paulkg12.t61.mvp.model.Milestone;
import com.paulkg12.t61.mvp.model.SearchResult;
import com.paulkg12.t61.mvp.model.User;
import com.paulkg12.t61.mvp.model.request.CommentRequestModel;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by ThirtyDegreesRay on 2017/9/20 14:28:30
 */

public interface IssueService {

    @NonNull @GET("repos/{owner}/{repo}/issues")
    @Headers("Accept: application/vnd.github.html,application/vnd.github.VERSION.raw")
    Observable<Response<ArrayList<Issue>>> getRepoIssues(
            @Header("forceNetWork") boolean forceNetWork,
            @Path("owner") String owner,
            @Path("repo") String repo,
            @Query("state") String state,
            @Query("sort") String sort,
            @Query("direction") String direction,
            @Query("page") int page
    );

    @NonNull @GET("user/issues")
    @Headers("Accept: application/vnd.github.html,application/vnd.github.VERSION.raw")
    Observable<Response<ArrayList<Issue>>> getUserIssues(
            @Header("forceNetWork") boolean forceNetWork,
            @Query("filter") String filter,
            @Query("state") String state,
            @Query("sort") String sort,
            @Query("direction") String direction,
            @Query("page") int page
    );

    @NonNull @GET("repos/{owner}/{repo}/issues/{issueNumber}")
    @Headers("Accept: application/vnd.github.html,application/vnd.github.VERSION.raw," +
            "application/vnd.github.squirrel-girl-preview")
    Observable<Response<Issue>> getIssueInfo(
            @Header("forceNetWork") boolean forceNetWork,
            @Path("owner") String owner,
            @Path("repo") String repo,
            @Path("issueNumber") int issueNumber
    );

    @NonNull @GET("repos/{owner}/{repo}/issues/{issueNumber}/timeline?per_page=60")
    @Headers("Accept: application/vnd.github.mockingbird-preview,application/vnd.github.html," +
            " application/vnd.github.VERSION.raw,application/vnd.github.squirrel-girl-preview")
    Observable<Response<ArrayList<IssueEvent>>> getIssueTimeline(
            @Header("forceNetWork") boolean forceNetWork,
            @Path("owner") String owner,
            @Path("repo") String repo,
            @Path("issueNumber") int issueNumber,
            @Query("page") int page
    );

    @NonNull @GET("repos/{owner}/{repo}/issues/{issueNumber}/comments")
    @Headers("Accept: application/vnd.github.html, application/vnd.github.VERSION.raw," +
            " application/vnd.github.squirrel-girl-preview")
    Observable<Response<ArrayList<IssueEvent>>> getIssueComments(
            @Header("forceNetWork") boolean forceNetWork,
            @Path("owner") String owner,
            @Path("repo") String repo,
            @Path("issueNumber") int issueNumber,
            @Query("page") int page
    );

    @NonNull @GET("repos/{owner}/{repo}/issues/{issueNumber}/events")
    @Headers("Accept: application/vnd.github.html")
    Observable<Response<ArrayList<IssueEvent>>> getIssueEvents(
            @Header("forceNetWork") boolean forceNetWork,
            @Path("owner") String owner,
            @Path("repo") String repo,
            @Path("issueNumber") int issueNumber,
            @Query("page") int page
    );

    @NonNull @POST("repos/{owner}/{repo}/issues/{issueNumber}/comments")
    @Headers("Accept: application/vnd.github.html,application/vnd.github.VERSION.raw," +
            "application/vnd.github.squirrel-girl-preview")
    Observable<Response<IssueEvent>> addComment(
            @Path("owner") String owner,
            @Path("repo") String repo,
            @Path("issueNumber") int issueNumber,
            @Body CommentRequestModel body
    );

    @NonNull @PATCH("repos/{owner}/{repo}/issues/comments/{commentId}")
    @Headers("Accept: application/vnd.github.html,application/vnd.github.VERSION.raw," +
            "application/vnd.github.squirrel-girl-preview")
    Observable<Response<IssueEvent>> editComment(
            @Path("owner") String owner,
            @Path("repo") String repo,
            @Path("commentId") String commentId,
            @Body CommentRequestModel body
    );

    @NonNull @DELETE("repos/{owner}/{repo}/issues/comments/{commentId}")
    Observable<Response<ResponseBody>> deleteComment(
            @Path("owner") String owner,
            @Path("repo") String repo,
            @Path("commentId") String commentId
    );

    @NonNull @PATCH("repos/{owner}/{repo}/issues/{issueNumber}")
    @Headers("Accept: application/vnd.github.html,application/vnd.github.VERSION.raw," +
            "application/vnd.github.squirrel-girl-preview")
    Observable<Response<Issue>> editIssue(
            @Path("owner") String owner,
            @Path("repo") String repo,
            @Path("issueNumber") int issueNumber,
            @Body IssueRequestModel body
    );

    @NonNull @POST("repos/{owner}/{repo}/issues")
    @Headers("Accept: application/vnd.github.html,application/vnd.github.VERSION.raw," +
            "application/vnd.github.squirrel-girl-preview")
    Observable<Response<Issue>> createIssue(
            @Path("owner") String owner,
            @Path("repo") String repo,
            @Body Issue body
    );

    /**
     * List all labels for this repository
     */
    @NonNull @GET("repos/{owner}/{repo}/labels")
    Observable<Response<ArrayList<Label>>> getRepoLabels(
            @Header("forceNetWork") boolean forceNetWork,
            @Path("owner") String owner,
            @Path("repo") String repo
    );

    @NonNull @POST("repos/{owner}/{repo}/labels")
    Observable<Response<Label>> createLabel(
            @Path("owner") String owner,
            @Path("repo") String repo,
            @Body Label body
    );

    @NonNull @PATCH("repos/{owner}/{repo}/labels/{labelName}")
    Observable<Response<Label>> updateLabel(
            @Path("owner") String owner,
            @Path("repo") String repo,
            @Path("labelName") String labelName,
            @Body Label body
    );

    @NonNull @DELETE("repos/{owner}/{repo}/labels/{labelName}")
    Observable<Response<ResponseBody>> deleteLabel(
            @Path("owner") String owner,
            @Path("repo") String repo,
            @Path("labelName") String labelName
    );

    @NonNull @GET("repos/{owner}/{repo}/milestones")
    Observable<Response<ArrayList<Milestone>>> getRepoMilestones(
            @Header("forceNetWork") boolean forceNetWork,
            @Path("owner") String owner,
            @Path("repo") String repo
    );

    @NonNull @GET("repos/{owner}/{repo}/assignees")
    Observable<Response<ArrayList<User>>> getRepoAssignees(
            @Header("forceNetWork") boolean forceNetWork,
            @Path("owner") String owner,
            @Path("repo") String repo
    );
    @NonNull @GET @Headers("Accept: application/vnd.github.html")
    Observable<Response<ResponseBody>> getFileAsHtmlStream(
            @Header("forceNetWork") boolean forceNetWork,
            @Url String url
    );

    @NonNull @GET @Headers("Accept: application/vnd.github.VERSION.raw")
    Observable<Response<ResponseBody>> getFileAsStream(
            @Header("forceNetWork") boolean forceNetWork,
            @Url String url
    );
    //    https://api.github.com/search/issues?sort=created&page=1&q=user:ThirtyDegreesRay+state:open&order=desc
    @NonNull @GET("search/issues")
    @Headers("Accept: application/vnd.github.html,application/vnd.github.VERSION.raw")
    Observable<Response<SearchResult<Issue>>> searchIssues(
            @Header("forceNetWork") boolean forceNetWork,
            @Query(value = "q", encoded = true) String query,
            @Query("sort") String sort,
            @Query("order") String order,
            @Query("page") int page
    );
}

