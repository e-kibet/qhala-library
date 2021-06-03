SELECT
      u.user_id,
      username,
      course_id,
      course_date,
      count( user_course_id ) AS count
  FROM users u JOIN courses t ON t.user_id = u.user_id
  GROUP BY u.user_id,
           username,
           course_id,
           course_date
  HAVING count( user_course_id ) > 1
  ORDER BY course_date DESC;



SELECT p.name, u.file_name FROM products p LEFT JOIN uploads u ON u.uploadable_id = p.id GROUP BY p.name ORDER BY u.id;
