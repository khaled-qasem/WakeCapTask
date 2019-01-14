package com.khaled.wakecap.wakecaptask.network

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class ApisHeadersInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        request = request.newBuilder()
            .addHeader("Content-Type", "application/json")
            .addHeader("X-Requested-With", "XMLHttpRequest")
            .addHeader("Authorization", token)
            .build()
        return chain.proceed(request)
    }
}

const val token =
    "Bearer eyJlbmMiOiJBMTI4Q0JDLUhTMjU2Iiwi" +
            "YWxnIjoiUlNBLU9BRVAiLCJraWQiOiIzaGltWWEyYmJHS18zSVdZMUxUUHdyTUl2ZkF3ZVhZQmRNLTU5XzN6c0" +
            "MwIn0.DIwk0Q215_M7rt3iGfyRVrImhKCXvEB5NBoLQj6iqBnN9yCWWBhGW9fmX6beOajtWgC8gpupe1hJ-iurFRbo2" +
            "Eg52Nh9ljkkO5Mz8ulSpH7YlfP8Yi-TBrNoPIf_IvHrr1Rt8bG0w2Ie1Jo3BBOguMQ6Q2WI4fQDY-oFIluxOQ5t9E0_XvDhn" +
            "a7maiQnWevLbu80Mj7g643v5nvNWOdpSAXW91rZXIXdal_A_ffY-IUyvYhEJuOkyHWwNonuGjiGHWKPTjTR16w3seoSs4srkacOIN1c" +
            "mMdXKlkvlWSYCv5Nd8xJ_rTqA4GIyKLRSALYcuiTFMOIxeMIpPB5DjpMTOmOD72QnD8MHMx-SNHk2Yva5iPs__h_WXIKzjME6wRQxTBayfWcX" +
            "uA6loTdSXnV5Tfl63y62nYZUesh2ElcF5ZK_if3R70jTh-_dxAc8-EcxagAgeCAYNGx-i0fokA4Crfz0A9MKJv5XKn8hY-_4_AT-tsIwBQ6YWYISPBG" +
            "qyUFoBX0LGDEojIywQBXcLSqHRoah45IDW87TTjVTtPjKsxrIr9rl661dYKRE4ViTLGON0hRBmmNAOokcTNv4tEPBWDS5OPIVtnqkCruAV1YXGKMWpbGOlH6" +
            "pi2sLY5FtNP9h7nNKnK59gX_FMwXyLjzdPU7HkEEv2svTHN_vBFDUeE.UmwA_rn0FGSRXl4kVPrF3Q.lpZ6JQSke2wLCi3X18mNMAYs5x2nCk7LGrs65nOo" +
            "-cv8FQ1zfYz9qj7TdH26BxmIrtJiBlLkLhJJnWmSjceNsQnCaOFt36cStJKTHbRkydezuBJyIgvlQH-8Y3nTXLpIbo3JQjxTJ-lUwmY8bLnyxS91DaKE" +
            "jmip3DoXJLSa4uOivuC68npCCtPVFeHbdHrzS_wQTRsUEh1o0XtWI1TtW868mV3njXwtjHdKxp7Uk8wfY5i5R4qJHxXWgf8PuXJA99Hh1Jwzee_tuA67wn" +
            "PxvKf95mFkZVYZdDqNKrFkDE9B7-r5FjLi3pQZdTMXjFBGAMv20jrM5BuvCZLP9p6ugbG5pOBRUjBT5RtQpw48_th6pTa4W36MkBkh5TbXS27yuOXvi-b3" +
            "blcSCEiizEDcJvqm4DBwqCNlSR8iG_QgktFDzkG99--LHV4R956K6cAozVAeyv0Jo9mKfaTsRLlMNhfTFpPrZmR5hVb11CEmmLi9C84aK1eivlYOZenzdZ" +
            "KpYE2mBKjZXOl96PJ3jb-OwEO2MDw9fyGzez8NaVhWAGGw9rm1iXnQyGljOw_ufOr5GLPHXXMhjSGVpXbN65sCTv8p6XGZnJiW7otVUzzmxG_kYQ3tkFLT" +
            "yG9p6SG3GGBDVYG_pkDpPWavWlQdplIDTsOrjoXu-8sAYTx6GO_rGL13haW7KY9pRi9v3324zkNYOYL8CWWZzjcm26607lTEhpVWvkP4QwisGjvrAMoyj-G" +
            "nlKvyK1u-1sPcuRMUg-8AKRYzBdtlChoUOtdVwYsOHxiLAkRMBH4PRIqWyUNILmlugXGNA7umZxj8uWy2mKjpZ7M8D_YlR66tj4duARp0lJYfeuvDqbXAB" +
            "VuSoLs8qaEFuYXLfiTNH4zItNeMQjfzT_eh9S_ligNALdOb82FgZzYv5ZKbFMo2s9kwzAb4PdwyaZjIP4_UJiJBqOazslWJYpdMLY2ZHGwfg0ZFP3adV06" +
            "hbR1i9bJ7lyew2Dalqh9Sq-cFPg32-6rbZXYJnFFzfMks4FOJCgPOhCz2QODdbZU8_nQp_EQ4mIXnD2BR6BcCa3odD8rliM3IYOWnq3AhCHen55FwygCw6" +
            "-u61Q03m4httHFozE-x4YiQivTQ70YUmdYNMyU_chQ3WfiJzaOgEwjq8vIP0hasxiaE1fBG7PncjGCUNB9sFiyVYjmSbP68iIQFqQ10oo9hnMYVxs_nSde" +
            "m23fDNOutoikzjSHPo4_qxg-hNV0GDIrzBPLGsGw_W9agnUQOpwtpYycZ9v472FWhI5z0c8-8U7D9cV9s0ELyO9U7_vHhSoZJCq1edIFVVKTHsVfR2-vOlCHu" +
            "qlbH4TzqGtIzf-5nUuY7HQ4iIxdjOrfU2GtMaU_tB8v3ZsC2Nr7IMYeyeBhItOXccNnqHUhMyZ-LdHkoafendmWTnnMOlkK2l91Jil4tPrJyVn1YFlsbzobQOu" +
            "rrsz2MAW3Ew1ibTCsRvlKWRs8dOSAxoUBcQL-r9g5_BcF0wsV7xzWvIHFm7fOuqLGsjsrCMAuXKImA2tFYECpr6vqCq8ORdqapUOlMb0_K4Iae-AhEkbMVERgLS" +
            "3O05tRhQATMl2jnqA71DImzDoQMC_c45ELXToqX7x0oiINsOLQKBFQjiQ4-G9C1DJlZ67ZVtSN2PyKVNqMNegEtSz1uieOmkoXa1Vq62CrDp7KORToTHMZEV9uWe" +
            "7KAOzqYm7jwhEvFs2jgvSga9Au2YgzqxbBjpC8RDSQqhUZTQeg2gecFLRpIObQ._YXzEw0gT4HbLqcFfdWoFQ"