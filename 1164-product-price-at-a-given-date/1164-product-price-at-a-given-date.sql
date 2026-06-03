/* Write your T-SQL query statement below */
;with cte as (
    select
        a.product_id,
        max(isnull(b.change_date, a.change_date)) as last_changed_date
    from Products a
    left join Products b on a.product_id = b.product_id and b.change_date <= '2019-08-16'
    group by a.product_id
)
select
    a.product_id,
    case 
        when b.last_changed_date <= '2019-08-16' then a.new_price 
        else 10 
    end as price
from Products a 
join cte b on a.product_id = b.product_id and a.change_date = b.last_changed_date