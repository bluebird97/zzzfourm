package com.paulkg12.t61.common;
import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.request.RequestOptions;
import com.paulkg12.t61.AppConfig;
import com.paulkg12.t61.R;

@GlideModule
public class MyAppGlideModel extends AppGlideModule {

    @Override
    public boolean isManifestParsingEnabled() {
        return super.isManifestParsingEnabled();
    }

    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        super.applyOptions(context, builder);
        builder.setDiskCache(new InternalCacheDiskCacheFactory(context, AppConfig.IMAGE_MAX_CACHE_SIZE));
        RequestOptions requestOptions = RequestOptions.placeholderOf(R.mipmap.logo);
        builder.setDefaultRequestOptions(requestOptions);
    }

    @Override
    public void registerComponents(Context context, Glide glide, Registry registry) {
        super.registerComponents(context, glide, registry);
    }

}
