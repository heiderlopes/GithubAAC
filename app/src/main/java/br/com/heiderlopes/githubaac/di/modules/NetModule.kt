package br.com.heiderlopes.githubaac.di.modules

import br.com.heiderlopes.githubaac.BuildConfig
import br.com.heiderlopes.githubaac.data.remote.UserWebService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetModule {
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    fun provideRetrofit(gson: Gson,
                        @Named("githubURL")githubURL: String): Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(githubURL)
                .build()
    }

    @Provides
    @Singleton
    @Named("githubURL")
    fun provideGithubURL(): String {
        return BuildConfig.GITHUB_URL
    }

    @Provides
    @Singleton
    fun provideApiWebservice(restAdapter: Retrofit): UserWebService {
        return restAdapter.create(UserWebService::class.java)
    }
}