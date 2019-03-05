package misc;

import redis.clients.jedis.Jedis;

/**
 * Created by kraghunathan on 6/21/18.
 */
public class RedisViaJava {

    static String TAXONOMIES                   = "taxonomies";
    static String TAXONOMY                     = "taxonomy_%s";
    static String TAXONOMY_FLAT                = "taxonomy_%s_flat";
    static String CATEGORY                     = "category_%s";
    static String SEARCH_CATEGORY_BY_NAME      = "search_category_by_name_%s";
    static String SEARCH_CATEGORY_BY_ATTRIBUTE = "search_category_by_attribute_%s";
    static String RELATIONSHIP_TYPES           = "relationship_types";
    static String CACHE_AVAILABLE              = "cache_available";
    static String SNAPSHOT_DATE_UPDATED        = "date_updated";
    static String CACHE_BUILDING               = "cache_building";
    static String R_CATEGORY                   = "r_category_%s_%s";
    static String R_TAXONOMY_FLAT              = "r_taxonomy_%s_flat_%s";
    static String R_CATEGORY_RELATIONSHIP      = "r_category_relationship_%s";

    static String [] keys = {TAXONOMIES,TAXONOMY,TAXONOMY_FLAT,CATEGORY,SEARCH_CATEGORY_BY_NAME,SEARCH_CATEGORY_BY_ATTRIBUTE,RELATIONSHIP_TYPES,CACHE_AVAILABLE,SNAPSHOT_DATE_UPDATED,CACHE_BUILDING,R_CATEGORY,R_TAXONOMY_FLAT,R_CATEGORY_RELATIONSHIP};

    public static void main( String[] args) {

        // redis-13075.snc1.raas-shared2-staging.grpn:13075
        Jedis j = new Jedis("redis-13075.snc1.raas-shared2-staging.grpn", 13075);

        //Set<String> a = j.keys("taxonomy_*");
        //a.stream().forEach(System.out::println);

        //System.out.println( jedis.get( a.iterator().next()).toString() );
    }
}
