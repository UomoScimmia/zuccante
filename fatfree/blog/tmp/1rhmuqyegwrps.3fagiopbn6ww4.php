<h1>My Blog Administration</h1>
<p><a href='admin/add'>Add Article</a></p>
<table>
  <thead>
    <tr>
      <th>Title</th>
      <th>Date</th>
      <th>Author</th>
      <th colspan='2'>Actions</th>
    </tr>
  </thead>
  <tbody>
  <?php foreach (($list?:[]) as $item): ?>
    <tr>
      <td><?= $item['title'] ?></td>
      <td><?= $item['timestamp'] ?></td>
      <td><?= $item['author'] ?></td>
      <td><a href="admin/edit/<?= $item['id'] ?>">Edit</a></td>
      <td><a href="admin/delete/<?= $item['id'] ?>">Delete</a></td>
    </tr>
  <?php endforeach; ?>
  </tbody>
</table>