<?php
namespace App\Test\TestCase\Model\Table;

use App\Model\Table\CountReportedCommentsTable;
use Cake\ORM\TableRegistry;
use Cake\TestSuite\TestCase;

/**
 * App\Model\Table\CountReportedCommentsTable Test Case
 */
class CountReportedCommentsTableTest extends TestCase
{

    /**
     * Test subject
     *
     * @var \App\Model\Table\CountReportedCommentsTable
     */
    public $CountReportedComments;

    /**
     * Fixtures
     *
     * @var array
     */
    public $fixtures = [
        'app.count_reported_comments'
    ];

    /**
     * setUp method
     *
     * @return void
     */
    public function setUp()
    {
        parent::setUp();
        $config = TableRegistry::exists('CountReportedComments') ? [] : ['className' => CountReportedCommentsTable::class];
        $this->CountReportedComments = TableRegistry::get('CountReportedComments', $config);
    }

    /**
     * tearDown method
     *
     * @return void
     */
    public function tearDown()
    {
        unset($this->CountReportedComments);

        parent::tearDown();
    }

    /**
     * Test initialize method
     *
     * @return void
     */
    public function testInitialize()
    {
        $this->markTestIncomplete('Not implemented yet.');
    }

    /**
     * Test validationDefault method
     *
     * @return void
     */
    public function testValidationDefault()
    {
        $this->markTestIncomplete('Not implemented yet.');
    }
}
