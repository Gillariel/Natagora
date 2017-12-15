<?php
namespace App\Test\TestCase\Model\Table;

use App\Model\Table\CountUsersTable;
use Cake\ORM\TableRegistry;
use Cake\TestSuite\TestCase;

/**
 * App\Model\Table\CountUsersTable Test Case
 */
class CountUsersTableTest extends TestCase
{

    /**
     * Test subject
     *
     * @var \App\Model\Table\CountUsersTable
     */
    public $CountUsers;

    /**
     * Fixtures
     *
     * @var array
     */
    public $fixtures = [
        'app.count_users'
    ];

    /**
     * setUp method
     *
     * @return void
     */
    public function setUp()
    {
        parent::setUp();
        $config = TableRegistry::exists('CountUsers') ? [] : ['className' => CountUsersTable::class];
        $this->CountUsers = TableRegistry::get('CountUsers', $config);
    }

    /**
     * tearDown method
     *
     * @return void
     */
    public function tearDown()
    {
        unset($this->CountUsers);

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
