<?php
namespace App\Test\Fixture;

use Cake\TestSuite\Fixture\TestFixture;

/**
 * TagForumFixture
 *
 */
class TagForumFixture extends TestFixture
{

    /**
     * Table name
     *
     * @var string
     */
    public $table = 'tag_forum';

    /**
     * Fields
     *
     * @var array
     */
    // @codingStandardsIgnoreStart
    public $fields = [
        'Forum_ID' => ['type' => 'integer', 'length' => 11, 'unsigned' => false, 'null' => false, 'default' => null, 'comment' => '', 'precision' => null, 'autoIncrement' => null],
        'Tag_ID' => ['type' => 'integer', 'length' => 11, 'unsigned' => false, 'null' => false, 'default' => null, 'comment' => '', 'precision' => null, 'autoIncrement' => null],
        '_indexes' => [
            'FK_Tags_Forums_Dev_Tag_ID' => ['type' => 'index', 'columns' => ['Tag_ID'], 'length' => []],
            'FK_Forum' => ['type' => 'index', 'columns' => ['Forum_ID'], 'length' => []],
        ],
        '_constraints' => [
            'primary' => ['type' => 'primary', 'columns' => ['Forum_ID', 'Tag_ID'], 'length' => []],
            'FK_Tag_Forum_Forum' => ['type' => 'foreign', 'columns' => ['Forum_ID'], 'references' => ['forum', 'ID'], 'update' => 'restrict', 'delete' => 'restrict', 'length' => []],
            'FK_Tag_Forum_Tag' => ['type' => 'foreign', 'columns' => ['Tag_ID'], 'references' => ['tag', 'ID'], 'update' => 'restrict', 'delete' => 'restrict', 'length' => []],
        ],
        '_options' => [
            'engine' => 'InnoDB',
            'collation' => 'latin1_swedish_ci'
        ],
    ];
    // @codingStandardsIgnoreEnd

    /**
     * Records
     *
     * @var array
     */
    public $records = [
        [
            'Forum_ID' => 1,
            'Tag_ID' => 1
        ],
    ];
}
